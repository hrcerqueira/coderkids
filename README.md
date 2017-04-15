A small and simple language interpreter, to be run in a browser, intended to help people learn simple language concepts. 

###settings

- minVarNameLength, default 2
- assignmentKeywords, default "is", "is a"
- nullKeywords, default "nothing", "none"
- decimalSeparator, default '.'

###language docs (based on default settings)

####scalars

All numbers are floating point numbers (in fact they are big decimals at the core).

```
5
1024
3.5
0.34756754
```

####variables
variables work like python, no special keyword, just assign a value and go

```
numberOfPeople is 5
```
