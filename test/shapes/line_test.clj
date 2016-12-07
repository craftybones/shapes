(ns shapes.line-test
  (:require [clojure.test :refer :all]
            [shapes.line :refer :all]))

(deftest line-test
  (let [line-of-stars (partial line "*")]
    (testing "A single line of stars"
      (is (= "*" (line-of-stars 1)))
      (is (= "**" (line-of-stars 2)))
      (is (= "***" (line-of-stars 3))))))
