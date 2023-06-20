# Readabilit Score

## About the project
Everyone has their own personal reading history, and as we grow up, we are able to comprehend more and more complicated texts. <br/> 
But how do you estimate the difficulty level of a given text, and how do you teach a computer to do that? <br/> 
This program determines how difficult the text is and for which age it is most suitable.

## Description

### Automated readability index (ARI) ###
It was introduced in 1968, and much research works on this. <br/> The index is calculated by the following formula:

![image](https://github.com/Hubertoom/Readability_Score/assets/137101859/d7866fde-77e3-4b7d-8fa5-b1a90767f7b7)

Below you can see the table that specifies the age brackets.
![image](https://github.com/Hubertoom/Readability_Score/assets/137101859/94329090-bf72-448f-b60d-ccb9443ce95c)

You can read more about it [in this article](https://en.wikipedia.org/wiki/Automated_readability_index)


### Flesch-Kincaid readability tests ###

This algorithm allows you to determine the age of the person for whom the text will be suitable. <br/>
The following formula: 

![image](https://github.com/Hubertoom/Readability_Score/assets/137101859/95ae807b-11a1-446a-b4f3-ad818ef88d2c)

More information in [the corresponding article on Wikipedia](https://en.wikipedia.org/wiki/Flesch%E2%80%93Kincaid_readability_tests)


### SMOG index ###
The SMOG grade is a measure of readability that estimates the years of education needed to understand a piece of writing. <br/>
SMOG is an acronym for "Simple Measure of Gobbledygook". 
The text should contain at least 30 sentences to determine the correct result. <br/>
The algorithm follows this formula: 

![image](https://github.com/Hubertoom/Readability_Score/assets/137101859/4dbc8076-e0d1-4182-b681-8b74f169e74f)

More information in [the corresponding article on Wikipedia](https://en.wikipedia.org/wiki/SMOG)


### Coleman-Liau index ###
Like all other indices, the output is a person's grade level. <br/> 
The result is a minimum grade level required to understand this text. <br/>
Like the ARI, but unlike most of the other indices, Coleman–Liau relies on characters instead of syllables per word. <br/>
Here is the formula:

![image](https://github.com/Hubertoom/Readability_Score/assets/137101859/fcf01915-34ca-4787-ae9a-32cbc5a475cb)

More information in [the corresponding article on Wikipedia](https://en.wikipedia.org/wiki/Coleman%E2%80%93Liau_index)

