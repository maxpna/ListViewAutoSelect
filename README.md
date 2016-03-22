###Under construction.

# ListViewAutoSelect

# Table of Contents
1. [Overview](#overview)
2. [How to download ListViewAutoSelect]
 1. [Single File](#single-file)
 2. [Android Project](#android-project)
3. [How to Use](#how-to-use)
 1. [Downloading a Single File](#downloading-a-single-file)
 2. [Downloading Multiple Files](#downloading-multiple-files)

##Overview

This project is a complete Android project showing how to create a list adapter that can auto select as you type into an input field. An 
example of this would be: a list of all the states in the U.S. You start typing in 'T' and you'll see only the states that contain the 
letter 'T'. In this case you'll see Texas, Tennessee, etc. etc.

The main process for implementing is listed below:

1. Extend BaseAdapterAutoSelect and provide your own getView() implementation
2. Write your object that represents each row in the listview. If you're just using strings, then just pass strings
3. Implement a watcher for your input so that everytime the input changes, you call .RefreshData on the adapter.
