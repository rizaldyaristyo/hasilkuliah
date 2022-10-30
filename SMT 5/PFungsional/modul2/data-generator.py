users = [
    {
        'role': 'teacher',
        'username': 'ari',
        'password': 'ari123',
        'nama': 'Ari',
        'nilai_uh_1': 0,
        'nilai_uh_2': 0,
        'nilai_uh_3': 0,
        'nilai_uas': 0
    },{
        'role': 'student',
        'username': 'upi',
        'password': 'upi123',
        'nama': 'Upi',
        'nilai_uh_1': 85,
        'nilai_uh_2': 90,
        'nilai_uh_3': 95,
        'nilai_uas': 100
    }
]

def save_dict(dic):
    f = open('dict.txt','w+')
    f.write(str(dic))
    f.close()

def load_dict():
    f = open('dict.txt','r')
    data=f.read()
    f.close()
    return eval(data)

class DictIterator:
    def __init__(self, ext_dict):
        self.ext_dict = ext_dict
        self.index = 0
    def __iter__(self):
        return self
    def __next__(self):
        if self.index == len(self.ext_dict):
            raise StopIteration
        else:
            self.index += 1
            return self.ext_dict[self.index - 1]

save_dict(users)

dict_iterator = DictIterator(load_dict())
print(next(dict_iterator))
print(next(dict_iterator))

def save_conf(data):
    f = open('conf.txt','w+')
    f.write(str(data))
    f.close()

def load_conf():
    f = open('conf.txt','r')
    data=f.read()
    f.close()
    return eval(data)

datanya = {
    "exam_attempt_left": 3,
    "last_date": "30-01-2020"
}

save_conf(datanya)
print(load_conf()['exam_attempt'])