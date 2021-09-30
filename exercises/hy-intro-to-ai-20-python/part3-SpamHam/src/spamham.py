import os

from math import exp, log
from typing import Dict, List

SMALL_NUMBER = 0.00001


def get_occurrences(filename) -> Dict[str, int]:
    results = {}
    dir_path = os.path.dirname(os.path.realpath(__file__))

    try:
        with open(os.path.join(dir_path, "..", filename)) as file:
            for line in file:
                count, word = line.strip().split(" ")
                results[word] = int(count)

        return results

    except FileNotFoundError:
        print("File %s was not found." % filename)
        raise
    except Exception as e:
        print("Something terrible happened: %s" % str(e))
        raise


def get_words(filename):
    dir_path = os.path.dirname(os.path.realpath(__file__))

    try:
        with open(os.path.join(dir_path, "..", filename)) as file:
            words = [word for line in file for word in line.split()]

        return words

    except FileNotFoundError:
        print("File %s was not found." % filename)
        raise
    except Exception as e:
        print("Something terrible happened: %s", str(e))
        raise


class SpamHam:
    """Naive Bayes spam filter
    :attr spam: dictionary of occurrences for spam messages {word: count}
    :attr ham: dictionary of occurrences for ham messages {word: count}
    """

    def __init__(self, spam_file, ham_file):
        self.spam = get_occurrences(spam_file)
        self.ham = get_occurrences(ham_file)

        self.spam_count = sum(self.spam.values())
        self.ham_count = sum(self.ham.values())

    def evaluate_from_file(self, filename):
        words = get_words(filename)
        return self.evaluate(words)

    def evaluate_from_input(self):
        words = input().split()
        return self.evaluate(words)

    def evaluate(self, words: List[str]):
        """
        :param words: Array of str
        :return: probability that the message is spam (float)
        """
        r = exp(sum(self.spam_probability(w) - self.ham_probability(w) for w in words))
        return r / (1 + r)

    def spam_probability(self, word: str):
        return probability(self.spam.get(word, 0), self.spam_count)

    def ham_probability(self, word: str):
        return probability(self.ham.get(word, 0), self.ham_count)


def probability(count: int, total: int):
    if count == 0:
        return log(SMALL_NUMBER)
    else:
        return log(count / total)
