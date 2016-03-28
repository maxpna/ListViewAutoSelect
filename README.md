# ListViewAutoSelect

# Table of Contents
1. [Overview](#overview)
2. [How to download ListViewAutoSelect](#how-to-download-listviewautoselect)
 1. [Single File](#single-file)
 2. [Android Project](#android-project)
3. [How to Use](#how-to-use)
 1. [Make a List Item Object and Override toString()](#make-a-list-item-object-and-override-tostring)
 2. [Extend BaseAdapterAutoSelect](#extend-baseadapterautoselect)
 3. [Triggering Update](#triggering-update)
4. [Initialize Adapter](#initialize-adapter)

##Overview

This is a complete Android project showing how to create a list adapter that can auto select as you type into an input field. An 
example of this would be: a list of all the states in the U.S. You start typing in 'T' and you'll see only the states that contain the 
letter 'T'. In this case you'll see Texas, Tennessee, Washington, etc. etc.

You can get either the list adapter or the entire project.

The main steps for implementing a solution are:

1. Extend BaseAdapterAutoSelect and provide your own getView() implementation.
2. Write your object that represents each row in the listview (Unless you're just using strings).
3. Implement a watcher for your input so that everytime the input changes, you call .RefreshData on the adapter.
4. Initialize adapter.


##How to Download ListViewAutoSelect

You can either download a single file and copy to your project or you can download the entire android project and play with it.

###Single File
To download the single file use the following location:
* https://github.com/maxpower-ndrd/ListViewAutoSelect/blob/master/app/src/main/java/com/mpn/listviewautoselect/listadapters/BaseAdapterAutoSelect.java

###Android Project
You can download the Android Studio project using any of the methods listed here.
* Make a git clone of the repo over https
```
git clone https://github.com/maxpower-ndrd/ListViewAutoSelect.git
```
* Make a git clone of the repo over ssh
```
git clone git@github.com:maxpower-ndrd/ListViewAutoSelect.git
```
* Use the [Download Zip](https://github.com/maxpower-ndrd/ListViewAutoSelect/archive/master.zip) link from the projects [main page](https://github.com/maxpower-ndrd/ListViewAutoSelect)

##How to Use

To use this you must follow the steps listed below

###Make a List Item Object and Override toString()

Make your class that will be used to store the data represented in a single row. It could be part of your model, a simplified model just used for the listvew, or just a regular string. If you're just using regular strings, you don't need this object.

You must override the toString() function to return the display name that will be searched when the user starts typing.

For this exercise, we'll assume the sample object looks like the following. Note: write your property accessors properly as needed.
```
public class StateObject {
  public String Name="";
  public String StateCapital="";
  public String StateLetters="";
  public boolean Selected=false;

  @Override
  public String toString() {
    return Name;
  }
}
```

###Extend BaseAdapterAutoSelect
Extends the BaseAdapterAutoSelect and provide your getView(). If you need to store context or other items, add those private variables. 

```
public class SampleAdapterAutoSelect extends BaseAdapterAutoSelect<StateObject> {
  // private vars
  
  public SampleAdapterAutoSelect(List<StateObject> Items, Context ctx) {
    super(Items);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    // implement viewholder patterns and any other efficiency affecting patterns. this is just a sample
    
    // to refer to the list containing the data, use .items here.
    // StateObject item = getItem(position);  // this is your current object

    // implement a view
    
    return convertView;
  }
}
```
###Triggering Update
To trigger an update when the input is updated, add a listener to your EditText or other input control so you can determine when to update the listview. When the EditText or any other input changes, call the following method on the list adapter.
```
public void RefreshData(String searchString)
```
The following example shows an EditText, a listener and a call to RefreshData.
```
    // assign a change listener to edittext.
    EditText edit=(EditText)findViewById(R.id.txtInput);
    edit.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
       adapter.RefreshData(s.toString());
      }

      @Override
      public void afterTextChanged(Editable s) { }
    });
```
###Initialize Adapter
In your main activity, initialize the adapter with a blank filter. In your onCreate, put the following call.
```
    adapter.RefreshData("");
```
