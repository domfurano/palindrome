#lang racket

(define (is-palindrome str)
  (define downcase-str
    (string-downcase
     (regexp-replace* #px"\\W" str "")))
  (define rev-str
    (list->string
     (reverse
      (string->list downcase-str))))
  (string=? rev-str downcase-str))

(require rackunit)

(define palindrome-lines (file->lines "palindromes.txt"))
(define not-palindrome-lines (file->lines "not-palindromes.txt"))

(for-each (λ (arg)
            (check-true
             (is-palindrome arg)))
          palindrome-lines)

(for-each (λ (arg)
            (check-false
             (is-palindrome arg)))
          not-palindrome-lines)


(print "All test passed!")