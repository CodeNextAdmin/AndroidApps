/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.touringmusician;


import android.graphics.Point;
import android.util.Log;

import java.util.Iterator;


//http://www.vias.org/javacourse/chap14_02.html
//https://www.javatpoint.com/program-to-insert-a-new-node-at-the-beginning-of-the-circular-linked-list



public class CircularLinkedList implements Iterable<Point> {

    private class Node {
        Point point;
        Node prev, next;



        public Node(Point point) {
            this.point = point;


        }
    }

    Node head;

    public Point getCurrent(){

        return head.point;
    }
    public Point getPrev(){

        return head.prev.point;
    }

    public void insertBeginning(Point p) {

//        Your first implementation task will be to implement the insertBeginning method. Your code should:
//
//        1. create a new Node representing the passed-in Point
//        2. add that Node to the beginning of the list

        Log.d("InsertMode", "insertBeginning : " + p.toString());

        Node newNode = new Node(p);

        if(head ==null){

            head = newNode;
            newNode.next = head;
            newNode.prev = head;

            Log.d("Head is null", "head = newNode");
        }else{

            //if it's not the first node...

            newNode.next = head; // how can we illustrate this with pictures, physical activities?
            newNode.prev = head.prev;
            head.prev = newNode;
            newNode.prev.next = newNode; // I don't quite get this...
            head = newNode;


        }



        displayNodes();



    }

    private float distanceBetween(Point from, Point to) {

        float dist = (float) Math.sqrt(Math.pow(from.y-to.y, 2) + Math.pow(from.x-to.x, 2));

        Log.d("dist between", ": " + dist);
        return dist;

    }

    public float totalDistance() {
        float total = 0;

        total = distanceBetween(this.getPrev(), this.getCurrent());



        return total;
    }

    public void insertNearest(Point p) {
        /**
         **
         **  YOUR CODE GOES HERE
         **
         **/
    }

    public void insertSmallest(Point p) {
        /**
         **
         **  YOUR CODE GOES HERE
         **
         **/
    }

    public void reset() {
        head = null;
    }

    private class CircularLinkedListIterator implements Iterator<Point> {

        Node current;

        public CircularLinkedListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public Point next() {
            Point toReturn = current.point;
            current = current.next;
            if (current == head) {
                current = null;
            }
            return toReturn;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Iterator<Point> iterator() {
        return new CircularLinkedListIterator();
    }


    public void displayNodes(){

        Node current = head;

        if(head ==null){

            Log.d("displayNodes", "list is empty");
        } else {

            do{
                //Prints each node by incrementing pointer.
                Log.d("displayNodes ", "current Point " + current.point);
                current = current.next;
            }while(current != head);
            System.out.println();
        }

    }


}
