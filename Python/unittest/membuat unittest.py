import unittest


class StringMethodsTest(unittest.TestCase):

    def test_strip(self):
        self.assertEqual("www.dicoding.com".strip("cw.om"), "dicoding")

    def test_isalnum(self):
        self.assertTrue("d1c0ding".isalnum())
        self.assertFalse("d1c0d!ng".isalnum())

    def test_index(self):
        s = "dicoding"
        self.assertEqual(s.index("coding"), 2)

        with self.assertRaises(ValueError):
            s.index("decode")


if __name__ == "__main__":
    unittest.main()
