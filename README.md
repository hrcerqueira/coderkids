A small and simple language interpreter, to be run in a browser, intended to help people learn simple language concepts. The syntax is very configurable and can adapt to human languages and other syntaxes more familiar to the apprentice.

###settings

- minVarNameLength, default 2
- assignmentKeywords, default "is", "is a"
- nullKeywords, default "nothing", "none"
- decimalSeparator, default '.'
- stringDelimiters, default ""
- stringEscapeChar, default \

###language docs (based on default settings)

####variables
variables work like python, no special keyword, just assign a value and go

```
numberOfPeople is 5
```

A variable name must start with lower case and have at least 2 characters.

####scalars

All numbers are floating point numbers (in fact they are big decimals at the core).

```
5
1024
3.5
0.34756754
```

Strings are surrounded by double quotes and can contain any character including new lines. Escape characters can be used for tabs, newlines and quotes.

```
userName is "mike"

poem is "roses are red
violets are blue
something something
something for you"

aVariable is "userName is \"mike\""
```



