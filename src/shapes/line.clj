(ns shapes.line
  (:require [shapes.utils :refer :all])
  (:gen-class))

(def line
  "creates a string of repeated elements"
  (flip repeat-string))

(def empty-line
  "creates a string of spaces"
  (partial line " "))

(defn bordered-line 
  "creates a string of two c's separated by n-2 spaces"
  [c n]
  (condp = n
    0 ""
    1 c
    (str c (empty-line (- n 2)) c)))

(defn right-justify
  "Right justifies the string s with a maximum length of n"
  [n s]
  (str (empty-line (- n (count s))) s))

(defn center-justify
  "Center justifies the string s with a maximum length of n"
  [n s]
  (str (empty-line (quot (- n (count s)) 2)) s))
