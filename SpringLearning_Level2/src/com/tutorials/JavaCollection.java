package com.tutorials;

import java.util.*;

import org.springframework.beans.factory.annotation.Required;

public class JavaCollection {
   private List tempList;
   private Set tempSet;
   private Map tempMap;
   private Properties tempPros;
public Properties getTempPros() {
	return tempPros;
}
public void setTempPros(Properties tempPros) {
	System.out.println("Properties are :" + tempPros);
	this.tempPros = tempPros;
}
public List getTempList() {
	System.out.println("List is :" + tempList);
	return tempList;
}
public void setTempList(List tempList) {
	this.tempList = tempList;
}
public Set getTempSet() {
	System.out.println("Set is : " + tempSet);
	return tempSet;
}

@Required
public void setTempSet(Set tempSet) {
	this.tempSet = tempSet;
}
public Map getTempMap() {
	System.out.println("Map is :" + tempMap);
	return tempMap;
}
public void setTempMap(Map tempMap) {
	this.tempMap = tempMap;
}
}
