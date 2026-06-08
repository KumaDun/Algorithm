import copy
from collections import deque
from typing import List


class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        domain = {}
        for r in range(9):
            for c in range(9):
                if board[r][c] == '.':
                    domain[(r, c)] = set("123456789")
                else:
                    domain[(r,c)] = {board[r][c]}

        neighbors = {}
        for r in range(9):
            for c in range(9):
                cells = set()
                # same row
                for k in range(9):
                    if k != c:
                        cells.add((r, k))
                # same col
                for k in range(9):
                    if k != r:
                        cells.add((k, c))
                # same block
                br = (r // 3) * 3
                bc = (c // 3) * 3
                for i in range(br, br + 3):
                    for j in range(bc, bc + 3):
                        if (i, j) == (r,c):
                            continue
                        cells.add((i, j))
                neighbors[(r, c)] = cells

        def revise(xi, xj): # return if xi domain is updated when considering (xi, xj) arc
            changed = False
            # Cannot shrink xi anymore because multiple value in xj
            if len(domain[xj]) != 1:
                return False
            value = list(domain[xj])[0]

            if value in domain[xi]:
                domain[xi].remove(value)
                return True
            return False

        def ac3():
            queue = deque()
            for xi in domain:
                for xj in neighbors[xi]:
                    queue.append((xi, xj))

            while queue:
                xi, xj = queue.popleft()
                if revise(xi, xj):
                    # if dead end return False
                    if len(domain[xi]) == 0:
                        return False
                    # if xi domain is shrunk, all of its neighbor except xj need to be reconsidered
                    for xk in neighbors[xi]:
                        if xk != xj:
                            queue.append((xk, xi))
            return True

        # dfs and backtrack
        def dfs_backtrack():
            unsolved = [cell for cell in domain if len(domain[cell])>1]
            if not unsolved:
                return True
            guess_cell = min(unsolved, key=lambda cell: len(domain[cell]))
            for value in list(domain[guess_cell]):
                domain_copy = copy.deepcopy(domain)
                domain[guess_cell] = {value}
                # recursion on ac3() and backtrack()
                if ac3():
                    if dfs_backtrack():
                        return True

                domain.clear()
                domain.update(domain_copy)
            return False

        ac3()
        dfs_backtrack()
        # propogate

        for r in range(9):
            for c in range(9):
                board[r][c] = list(domain[(r, c)])[0]