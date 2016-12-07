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

(deftest there-and-back-test
  (testing "creating a range that goes up and down"
    (is (= [0 1 0] (there-and-back 1)))
    (is (= [0 1 2 1 0] (there-and-back 0 2)))
    (is (= [1 3 5 3 1] (there-and-back 1 5 2)))
    (is (= [0 -1 0] (there-and-back 0 -1 -1)))
    (is (= [1 0 -1 0 1] (there-and-back 1 -1 -1)))
    (is (= [0 -2 -4 -2 0] (there-and-back 0 -4 -2)))
    (is (= 0 (first (there-and-back 1000000000000000N))))
    (is (= [] (there-and-back 1 0)))
    (is (= [] (there-and-back 0 1 -1)))
    (is (= [0] (there-and-back 0)))))
