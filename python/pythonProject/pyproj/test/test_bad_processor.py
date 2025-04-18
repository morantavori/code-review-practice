import unittest
from pyproj.bad.bad_processor import runProcess, globCounter


class Tester(unittest.TestCase):
    def test1(self):
        x = ['a', 'b']
        y = {'a': 1}
        z = {}
        a = ['b']
        b = {}
        c = True
        d = {}
        e = 'admin'

        res = runProcess(x, c, y, z, a, c, d, e)
        assert res['b'] == 1

    def test2(self):
        res = runProcess(['z'], False, {}, [], [], False, {}, 'guest')
        assert 'z' in res

    def test_counter(self):
        prev = globCounter
        runProcess(['z'], True, {}, [], [], False, {}, 'admin')
        assert globCounter == prev + 1


if __name__ == '__main__':
    unittest.main()
