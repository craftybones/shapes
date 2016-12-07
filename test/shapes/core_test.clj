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
