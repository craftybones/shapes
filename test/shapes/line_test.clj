(ns shapes.line-test
  (:require [clojure.test :refer :all]
            [shapes.line :refer :all]))

(deftest line-test
  (let [line-of-stars (partial line "*")]
    (testing "A single line of stars"
      (is (= "" (line-of-stars 0)))
      (is (= "*" (line-of-stars 1)))
      (is (= "**" (line-of-stars 2)))
      (is (= "***" (line-of-stars 3))))))

(deftest bordered-line-test
  (let [bordered-star-line (partial bordered-line "*")]
    (testing "A single hollow line bordered by stars"
      (is (= "" (bordered-star-line 0)))
      (is (= "*" (bordered-star-line 1)))
      (is (= "**" (bordered-star-line 2)))
      (is (= "* *" (bordered-star-line 3))))))

(deftest right-justify-test
  (testing "Right justifying strings"
    (is (= "*" (right-justify 0 "*")))
    (is (= "*" (right-justify 1 "*")))
    (is (= " *" (right-justify 2 "*")))
    (is (= "  *" (right-justify 3 "*")))
    (is (= "**" (right-justify 2 "**")))
    (is (= " **" (right-justify 3 "**")))))

(deftest right-justify-test
  (testing "Right justifying strings"
    (is (= "*" (right-justify 0 "*")))
    (is (= "*" (right-justify 1 "*")))
    (is (= " *" (right-justify 2 "*")))
    (is (= "  *" (right-justify 3 "*")))
    (is (= "**" (right-justify 2 "**")))
    (is (= " **" (right-justify 3 "**")))))

(deftest right-justify-test
  (testing "Right justifying strings"
    (is (= "*" (right-justify 0 "*")))
    (is (= "*" (right-justify 1 "*")))
    (is (= " *" (right-justify 2 "*")))
    (is (= "  *" (right-justify 3 "*")))
    (is (= "**" (right-justify 2 "**")))
    (is (= " **" (right-justify 3 "**")))))

(deftest center-justify-test
  (testing "Center justifying strings"
    (is (= "*" (center-justify 0 "*")))
    (is (= "*" (center-justify 1 "*")))
    (is (= "*" (center-justify 2 "*")))
    (is (= " *" (center-justify 3 "*")))
    (is (= " **" (center-justify 4 "**")))
    (is (= "  *" (center-justify 5 "*")))))
