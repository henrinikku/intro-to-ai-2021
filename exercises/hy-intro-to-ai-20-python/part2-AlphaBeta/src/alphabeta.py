from typing import List


TEMPLATE_FIELD = "|e|e|e|\n|e|e|e|\n|e|e|e|\n"
HUGE_NUMBER = 1000000


class AlphaBetaNode(object):
    def __init__(self):
        pass

    def generate_children(self) -> List:
        pass

    def is_max_node(self) -> bool:
        pass

    def is_end_state(self) -> bool:
        pass

    def value(self) -> int:
        pass


class TicTacToe(AlphaBetaNode):
    """Class that contains current state of the game and implements AlphaBetaNode methods
    :attr state: Current state of the board (str)
    :attr crosses_turn: Indicates whose turn it is (Boolean)
    """

    def __init__(self, state, crosses_turn):
        super().__init__()
        self.state: str = state
        self.crosses_turn: bool = crosses_turn

    def is_end_state(self):
        return ("?" not in self.state) or self.won("x") or self.won("o")

    def won(self, c):
        triples = [
            self.state[0:3],
            self.state[3:6],
            self.state[6:9],
            self.state[::3],
            self.state[1::3],
            self.state[2::3],
            self.state[0] + self.state[4] + self.state[8],
            self.state[2] + self.state[4] + self.state[6],
        ]
        combo = 3 * c
        return combo in triples

    def __str__(self):
        field = TEMPLATE_FIELD
        for c in self.state:
            field = field.replace("e", c, 1)

        return field

    def is_max_node(self):
        return self.crosses_turn

    def generate_children(self):
        """
        Generates list of all possible states after this turn
        :return: list of TicTacToe objects
        """
        c = "x" if self.crosses_turn else "o"
        return [
            TicTacToe(
                self.state[:i] + c + self.state[i + 1 :],
                not self.crosses_turn,
            )
            for i, slot in enumerate(self.state)
            if slot == "?"
        ]

    def value(self):
        """
        Current score of the game (0, 1, -1)
        :return: int
        """
        if self.won("x"):
            return 1
        if self.won("o"):
            return -1
        if "?" not in self.state:
            return 0
        raise RuntimeError(f"Not an end state: {self.state}")


def alpha_beta_value(node: AlphaBetaNode):
    """Implements the MinMax algorithm with alpha-beta pruning
    :param node: State of the game (TicTacToe)
    :return: int
    """
    value_func = max_value if node.is_max_node() else min_value
    return value_func(node, -1, 1)

def max_value(node: AlphaBetaNode, alpha: int, beta: int):
    if node.is_end_state():
        return node.value()

    value = -HUGE_NUMBER
    for child in node.generate_children():
        value = max(value, min_value(child, alpha, beta))
        alpha = max(alpha, value)
        if alpha >= beta:
            break
    return value


def min_value(node: AlphaBetaNode, alpha: int, beta: int):
    if node.is_end_state():
        return node.value()

    value = HUGE_NUMBER
    for child in node.generate_children():
        value = min(value, max_value(child, alpha, beta))
        beta = min(beta, value)
        if alpha >= beta:
            break
    return value
