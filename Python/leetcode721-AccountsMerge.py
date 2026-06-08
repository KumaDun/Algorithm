class Solution:
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        email_to_id = {}
        email_to_name = {}

        for account in accounts:
            name = account[0]
            for i in range(1, len(account)):
                if account[i] not in email_to_id:
                    idx = len(email_to_id)
                    email_to_id[account[i]] = idx
                    email_to_name[account[i]] = name

        us = UnionSet(len(email_to_id))
        for account in accounts:
            first_id = email_to_id[account[1]]
            for i in range(1, len(account)):
                us.union(first_id, email_to_id[account[i]])
        root_to_emails = defaultdict(list)
        for email, index in email_to_id.items():
            root = us.find(index)
            root_to_emails[root].append(email)
        result = []
        for root, emails in root_to_emails.items():
            name = email_to_name[emails[0]]
            result.append([name] + sorted(emails))
        return result


class UnionSet():
    def __init__(self, size):
        self.parents = list(range(size))
        self.ranks = [1] * size

    def union(self, a, b):
        rootA = self.find(a)
        rootB = self.find(b)
        if rootA == rootB:
            return
        if self.ranks[rootA] > self.ranks[rootB]:
            self.parents[rootB] = rootA
        elif self.ranks[rootA] < self.ranks[rootB]:
            self.parents[rootA] = rootB
        else:
            self.parents[rootB] = rootA
            self.ranks[rootA] += 1

    def find(self, a):
        if self.parents[a] != a:
            self.parents[a] = self.find(self.parents[a])
            return self.parents[a]
        else:
            return a