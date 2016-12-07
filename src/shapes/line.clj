(ns shapes.line
  (:require [shapes.utils :refer :all])
  (:gen-class))

(def line
  "creates a string of repeated elements"
  (flip repeat-string))

(def empty-line
  "creates a string of spaces"
  (partial line " "))

(defn bordered-line [c n]
  "creates a string of two c's separated by n-2 spaces"
  (condp = n
    0 ""
    1 c
    (str c (empty-line (- n 2)) c)))
