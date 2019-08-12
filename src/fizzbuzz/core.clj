(ns fizzbuzz.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn fizz? [n]
  (zero? (mod n 3)))


(defn buzz? [n]
  (zero? (mod n 5)))


(defn lucky? [n]
  (str/includes? (str n) "3"))


(defn fizzbuzz? [n]
  (and (fizz? n)
       (buzz? n)))


(defn fizzbuzzformatter
  ([n default]
   (cond
     (lucky? n)    "lucky"
     (fizzbuzz? n) "fizzbuzz"
     (fizz? n)     "fizz"
     (buzz? n)     "buzz"
     :else         default))
  ([n]
   (fizzbuzzformatter n n)))


(defn fizzbuzz
  ([start end formatter-fn]
   (->> (range start (inc end))
        (map formatter-fn)))
  ([start end]
   (fizzbuzz start end fizzbuzzformatter)))


(defn aggregatingformatter [n]
  (fizzbuzzformatter n "integer"))


(defn fizzbuzz-stats [start end]
  (frequencies
   (fizzbuzz start end aggregatingformatter)))


(defn parse-int [s]
  (try
    (Integer. (re-find  #"-?\d+" s ))
    (catch NumberFormatException e)))


(defn format-usage []
  "Usage: fizzbuzz start-int end-int")


(defn format-stats [stats]
  (str "fizz: " (get stats "fizz" 0) "\n"
       "buzz: " (get stats "buzz" 0) "\n"
       "fizzbuzz: " (get stats "fizzbuzz" 0) "\n\n"
       "lucky: " (get stats "lucky" 0) " ";; intentionally left newline to meet requirements
       "integer: " (get stats "integer" 0)))


(defn -main
  ([]    (println (format-usage)))
  ([arg] (println (format-usage)))
  ([start end & args]
   (let [start-int (parse-int start)
         end-int   (parse-int end)]
     (if (or (nil? start-int) (nil? end-int))
       (println (format-usage))
       (do
         (println (str/join " " (fizzbuzz start-int end-int)))
         (println (format-stats (fizzbuzz-stats start-int end-int))))))))
