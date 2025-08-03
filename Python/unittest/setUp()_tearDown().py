import unittest


def koneksi_ke_db():
    print("[terhubung ke db]")


def putus_koneksi_db(db):
    print("[tidak terhubung ke db {}]".format(db))


class User:
    username = ""
    aktif = False

    def __init__(self, db, username):  # using db sample
        self.username = username

    def set_aktif(self):
        self.aktif = True


class TestUser(unittest.TestCase):
    
    def setUp(self):
        self.db = koneksi_ke_db()
        self.dicoding = User(self.db, "dicoding")
        
    def tearDown(self):
        putus_koneksi_db(self.db)
    
    def test_user_default_not_active(self):
        self.assertFalse(self.dicoding.aktif) 
    
    def test_user_is_active(self):
        self.dicoding.set_aktif()
        self.assertTrue(self.dicoding.aktif) 

if __name__ == "__main__":
    unittest.main()
         
