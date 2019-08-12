(ns fizzbuzz.core-test
  (:require [clojure.test :refer :all]
            [fizzbuzz.core :refer :all]))

(deftest prints-correct-result-to-stdout
  (testing "Example 1 from the exercise"
    ;; given:
    (let [range-start "2"
          range-end   "16"
          ;; when:
          result      (with-out-str
                        (-main range-start range-end))]
          ;; then:
      ;; NOTE for the reviewer: this is literally copy&paste of what was in the attached pdf file, so I retained the format as the requirement
      (is (= "2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16
fizz: 3
buzz: 2
fizzbuzz: 1

lucky: 2 integer: 7\n" result))))

  (testing "Example 2 from the exercise"
    ;; given:
    (let [range-start "-3"
          range-end   "-1"
          ;; when:
          result      (with-out-str
                        (-main range-start range-end))]
      ;; then:
      ;; NOTE for the reviewer: this is literally copy&paste of what was in the attached pdf file, so I retained the format as the requirement
      (is (= "lucky -2 -1
fizz: 0
buzz: 0
fizzbuzz: 0

lucky: 1 integer: 2\n" result))))

  (testing "Example 3 from the exercise"
    ;; given:
    (let [range-start "2"
          range-end   "14"
          ;; when:
          result      (with-out-str
                        (-main range-start range-end))]
      ;; then:
      ;; NOTE for the reviewer: this is literally copy&paste of what was in the attached pdf file, so I retained the format as the requirement
      (is (= "2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14
fizz: 3
buzz: 2
fizzbuzz: 0

lucky: 2 integer: 6\n" result))))

  (testing "Example 4 from the exercise"
    ;; given:
    (let [range-start "1"
          range-end   "20"
          ;; when:
          result      (with-out-str
                        (-main range-start range-end))]
      ;; then:
      ;; NOTE for the reviewer: this is literally copy&paste of what was in the attached pdf file, so I retained the format as the requirement
      (is (= "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz
fizz: 4
buzz: 3
fizzbuzz: 1

lucky: 2 integer: 10\n" result)))))


(deftest checks-fizz?
  (testing "Verify if a number is fizz"
    (are [n result] (= (fizz? n) result)
      -3 true
      0  true
      1  false
      2  false
      3  true
      6  true)))


(deftest checks-buzz?
  (testing "Verify if a number is buzz"
    (are [n result] (= (buzz? n) result)
      -10 true
      -5 true
      0  true
      1  false
      2  false
      3  false
      5  true
      6  false)))


(deftest checks-fizzbuzz?
  (testing "Verify if a number is fizzbuzz"
    (are [n result] (= (fizzbuzz? n) result)
      -15 true
      -5 false
      0  true
      1  false
      2  false
      3  false
      5  false
      6  false
      30 true)))


(deftest checks-lucky?
  (testing "Verify if a number is lucky"
    (are [n result] (= (lucky? n) result)
      -13 true
      1   false
      0   false
      2   false
      9   false
      10  false
      13  true
      333 true)))


(deftest parsing-integers
  (testing "Verify integer parsing"
    (are [n result] (= (parse-int n) result)
      "-42141"          -42141
      "321"             321
      "4"               4
      "not-a-number"    nil
      "partly123number" 123)))


(deftest generating-statistics
  (testing "generates frequencies"
    (are [stats start end] (= stats (fizzbuzz-stats start end))
      {"fizz"     4
       "buzz"     3
       "fizzbuzz" 1
       "lucky"    2
       "integer"  10} 1 20)))


(deftest handles-incorrect-arguments
  (testing "Prints usage on no args"
    ;; given: no args
    (let [;; when:
          result      (with-out-str
                        (-main))]
      ;; then:
      (is (= result "Usage: fizzbuzz start-int end-int\n") 
          (= (with-out-str
               (-main)) result))))

  (testing "Prints usage on one arg"
    ;; given: no args
    (let [;; when:
          result      (with-out-str
                        (-main 1))]
      ;; then:
      (is (= result "Usage: fizzbuzz start-int end-int\n") 
          (= (with-out-str
               (-main)) result))))

  (testing "Prints usage on not-a-number-args"
    ;; given: no args
    (let [;; when:
          result      (with-out-str
                        (-main "a" "b"))]
      ;; then:
      (is (= result "Usage: fizzbuzz start-int end-int\n") 
          (= (with-out-str
               (-main)) result)))))
