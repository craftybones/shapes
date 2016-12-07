(ns shapes.utils-test
  (:require [clojure.test :refer :all]
            [shapes.utils :refer :all]))

(deftest flip-test
  (testing "flip works with function of arity 0"
    (is (= 0 ((flip +)))))
  (testing "flip works with function of arity 1"
    (is (= 2 ((flip inc) 1))))
  (testing "flip works with functions of arity greater than 1"
    (is (= 2 ((flip rem) 4 2)))))

(deftest stringify-test
  (testing "stringify a basic list"
    (is (= "123" (stringify [1 2 3])))
    (is (= "abc" (stringify ["a" "b" "c"])))))

(deftest flatten*-test
  (testing "flattening arbitrary arguments"
    (is (= [1 2] (flatten* 1 2)))
    (is (= [1 2 3] (flatten* 1 [2 3])))
    (is (= [1 2 2 1] (flatten* 1 (repeat 2 2) 1)))))
