import re

any_word_character = re.compile(r'\w')


def is_palindrome(s):
    return ''.join([c for c in s.lower() if re.match(any_word_character, c)]) == \
           ''.join([c for c in reversed(s.lower()) if re.match(any_word_character, c)])


def main():
    with open('palindromes.txt') as palindromes_file:
        lines = palindromes_file.readlines()
        results = [is_palindrome(line) for line in lines]
        assert all(results)
        print('Palindromes test passed!')
    with open('not-palindromes.txt') as not_palindromes_file:
        lines = not_palindromes_file.readlines()
        results = [not is_palindrome(line) for line in lines]
        assert all(results)
        print('Not palindromes test passed!')


if __name__ == '__main__':
    main()
