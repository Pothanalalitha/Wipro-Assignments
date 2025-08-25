package com.wipro.lalitha;

import java.util.Stack;

public class UndoStack
{
	public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Open File");
        stack.push("Edit File");
        stack.push("Save File");

        System.out.println("Stack: " + stack);

        
        String last = stack.pop();
        System.out.println("Undo: " + last);

        
        stack.push(last);
        System.out.println("Redo Stack: " + stack);
    }
}
