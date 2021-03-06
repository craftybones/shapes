(ns shapes.core-test
  (:require [clojure.test :refer :all]
            [shapes.core :refer :all]))

(deftest filled-rectangle-m-x-n
  (let [star-filled-rectangle (partial filled-rectangle "*")]
    (testing "A simple mxn star filled rectangle"
      (is (= [] (star-filled-rectangle 0 0)))
      (is (= [""] (star-filled-rectangle 1 0)))
      (is (= ["*"] (star-filled-rectangle 1 1)))
      (is (= ["**","**"] (star-filled-rectangle 2 2)))
      (is (= ["***","***"] (star-filled-rectangle 2 3))))))

(deftest hollow-rectangle-m-x-n
  (let [star-hollow-rectangle (partial hollow-rectangle "*")]
    (testing "A simple mxn star hollow rectangle"
      (is (= [] (star-hollow-rectangle 0 1)))
      (is (= ["*"] (star-hollow-rectangle 1 1)))
      (is (= ["*" "*"] (star-hollow-rectangle 2 1)))
      (is (= ["***","* *","***"] (star-hollow-rectangle 3 3))))))

(deftest alternating-rectangle-m-x-n
  (let [star-minus-rectangle (partial alternating-rectangle ["*" "-"])]
    (testing "A simple mxn rectangle alternating with * and -"
      (is (= ["*"] (star-minus-rectangle 1 1)))
      (is (= ["*","-"] (star-minus-rectangle 2 1)))
      (is (= ["***","---"] (star-minus-rectangle 2 3)))
      (is (= ["***","---", "***"] (star-minus-rectangle 3 3))))))

(deftest left-aligned-triangle-nxn
  (let [star-left-triangle (partial left-aligned-triangle "*")]
    (testing "A simple left aligned triangle of dimension n"
      (is (= [] (star-left-triangle 0)))
      (is (= ["*"] (star-left-triangle 1)))
      (is (= ["*" "**"] (star-left-triangle 2)))
      (is (= ["*" "**", "***"] (star-left-triangle 3))))))

(deftest right-aligned-triangle-nxn
  (let [star-right-triangle (partial right-aligned-triangle "*")]
    (testing "A simple right aligned triangle of dimension n"
      (is (= [] (star-right-triangle 0)))
      (is (= ["*"] (star-right-triangle 1)))
      (is (= [" *" "**"] (star-right-triangle 2)))
      (is (= ["  *" " **", "***"] (star-right-triangle 3))))))

(deftest filled-diamond-n
  (testing "A filled diamond of size n(at its widest)"
    (is (= [] (filled-diamond "*" 0)))
    (is (= [] (filled-diamond "*" 2)))
    (is (= ["*"] (filled-diamond "*" 1)))
    (is (= [" *" "***" " *"] (filled-diamond "*" 3)))
    (is (= ["  *" " ***" "*****" " ***" "  *"] (filled-diamond "*" 5)))))

(deftest hollow-diamond-n
  (testing "A filled diamond of size n(at its widest)"
    (is (= [] (hollow-diamond "*" 0)))
    (is (= [] (hollow-diamond "*" 2)))
    (is (= ["*"] (hollow-diamond "*" 1)))
    (is (= [" *" "* *" " *"] (hollow-diamond "*" 3)))
    (is (= ["  *" " * *" "*   *" " * *" "  *"] (hollow-diamond "*" 5)))))
