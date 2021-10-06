import logging
from dataclasses import dataclass
from random import random
from typing import List

logger = logging.getLogger(__name__)


@dataclass
class Parameters:
    E: int = 0
    B: int = 0
    EA: int = 0
    BA: int = 0
    BEA: int = 0
    A: int = 0


@dataclass
class Values:
    E: bool = False
    B: bool = False
    A: bool = False


def create_tuples(params: Parameters, n: int):
    for __ in range(n):
        values = Values(
            E=(random() < params.E),
            B=(random() < params.B),
        )

        if values.E and values.B:
            values.A = random() < params.BEA
        
        elif values.E:
            values.A = random() < params.EA

        elif values.B:
            values.A = random() < params.BA

        yield values


def estimate_probabilities(tuples: List[Values]):
    print("1. Among the tuples with A=1, what is the fraction where B=1?")
    a = [t for t in tuples if t.A]
    a_and_b = [t for t in a if t.B]
    print(len(a_and_b) / len(a))

    print("2. Among the tuples with A=1 and E=1, what is the fraction where B=1?")
    a_and_e = [t for t in tuples if t.A and t.E]
    a_and_e_and_b = [t for t in a_and_e if t.B]
    print(len(a_and_e_and_b) / len(a_and_e))

    """
    3. Give an interpretation to your answers for items 1 & 2. What probabilities do they approximate?

    I think they make sense. In my view, item 1 approximates how likely it is that an alarm is caused by an earthquake,
    and item 2 basically approximates how likely it is for earthquake and burglary to happen simultaneously 
    (since the probability for the alarm not going off in that case is extremely low).

    4. Are they in line with your intuition? In other words, do they make sense? In particular: which of the fractions is bigger and why?

    Yes. The first fraction is obviously bigger, because the P(B, E) < P(B)

    5. Repeat the experiment a couple of times to get a feeling of how much the results change just by chance. 
    (This is the nature of the Monte Carlo approximation.) Experiment with different values of n. 
    How does it affect the variability?

    The smaller the fraction is, the more it is affected overall and by the value of n.
    """


if __name__ == "__main__":
    logging.basicConfig(level=logging.INFO)

    model_params = Parameters(
        E=(1 / 111),
        B=(1 / 365),
        EA=0.81,
        BA=0.92,
        BEA=0.97,
        A=0.0095,
    )
    tuples = list(create_tuples(model_params, n=100000))
    estimate_probabilities(tuples)
