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
