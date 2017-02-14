#!/usr/bin/env python

import re
import sys

for line in sys.stdin:
	val = line.strip()
	(year, temp) = ("1979", 123)
	print "%s\t%s" % (year, temp)
