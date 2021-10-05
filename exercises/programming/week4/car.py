import logging
from dataclasses import dataclass
from random import random
from typing import List

logger = logging.getLogger(__name__)


@dataclass
class Parameters:
    b: int = 0
    br: int = 0
    bi: int = 0
    g: int = 0
    gis: int = 0
    sm: int = 0


@dataclass
class Values:
    b: bool = False
    r: bool = False
    i: bool = False
    g: bool = False
    s: bool = False
    m: bool = False


def create_tuples(params: Parameters, n: int):
    for __ in range(n):
        values = Values(
            b=(random() < params.b),
            g=(random() < params.g),
        )

        if values.b:
            values.r = random() < params.br
            values.i = random() < params.bi

        if values.g:
            values.s = random() < params.gis
            values.m = values.s and random() < params.sm

        yield values


def estimate_probabilities(tuples: List[Values]):
    # P(B | R,G,¬S)
    a = sum(all([t.b, t.r, t.g, not t.s]) for t in tuples) / len(tuples)
    b = sum(all([t.r, t.g, not t.s]) for t in tuples) / len(tuples)
    print_probability("P(B | R,G,¬S)", a, b)

    # P(S | R,I,G)
    a = sum(all([t.s, t.r, t.i, t.g]) for t in tuples) / len(tuples)
    b = sum(all([t.r, t.i, t.g]) for t in tuples) / len(tuples)
    print_probability("P(S | R,I,G)", a, b)

    # P(S | ¬R,I,G)
    a = sum(all([t.s, not t.r, t.i, t.g]) for t in tuples) / len(tuples)
    a = sum(all([not t.r, t.i, t.g]) for t in tuples) / len(tuples)
    print_probability("P(S | ¬R,I,G)", a, b)


def print_probability(formula: str, a: int, b: int):
    print(f"{formula}: {a} / {b} = {a / b}")


if __name__ == "__main__":
    logging.basicConfig(level=logging.INFO)

    model_params = Parameters(
        b=0.9,
        br=0.9,
        bi=0.95,
        g=0.95,
        gis=0.99,
        sm=0.99,
    )
    tuples = list(create_tuples(model_params, n=100000))
    estimate_probabilities(tuples)
