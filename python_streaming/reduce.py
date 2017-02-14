#!/usr/bin/env python

import sys

(a_key, a_value) = ("Default_key", 0)
for line in sys.stdin:
	(key, val) = line.strip().split("\t")
	(a_key, a_value) = (key, val)
print "%s\t%s" % (a_key, a_value)
