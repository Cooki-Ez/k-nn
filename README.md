# k-nn
k-nn algorithm implemeted in java. 
----------
TASK
----------
The goal is to implement the k-NN classifier. The program should take 3 arguments:
k: positive natural being the k-NN hiperparameter
train-set: name of the file containing csv train set
test-set: name of the file containing csv test set
The program should apply k-NN classifier based on the train set to each vector from
the test set and produce the accuracy (proportion of correctly classified examples from
the test set).
The program should additionally provide a simple interface (not necessarily graphical)
to make it possible to input single vectors by the user to be classified.
Optional extension: prepare a graph (excel, python, etc.) showing the accuracy vs the
value of k.
Test the program using training data in iris.data and test data in iris.test.data
(but the program should be able to load other datasets).
