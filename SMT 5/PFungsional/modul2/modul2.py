# This code is overly complicated. It's intended for learning: functional programming, iterator, generator, and yield without using any external library. Please don't use this in production, you can make a better program with less code and more readable than this, as we're just forced to apply things that just don't fit in this program.

def save_dict(dic):
    f = open('dict.txt','w+')
    f.write(str(dic))
    f.close()

def load_dict():
    f = open('dict.txt','r')
    data=f.read()
    f.close()
    return eval(data)

def exam_attempt_generator(n):
    for i in range(n,0,-1):
        yield i

def reset_exam_attempt(n=3):
    return exam_attempt_generator(n)

## attempt = reset_exam_attempt();print(next(attempt))# Generator Test

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

def initiate_dict_iterator(dictionary):
    return DictIterator(dictionary)

## for i in initiate_dict_iterator(): print(i)# Iterator Test

def teacher_menu(pass_attempt_generator):
    while True:
        print('\n[Menu Teacher]\
            \n0.Tampilkan Teachers\
            \n1.Tampilkan Students\
            \n2.Tambah Data\
            \n3.Edit Data\
            \n4.Hapus Data\
            \n5.[NEW] Input UH\
            \n6.IZIN OFF')
        pilih = input('Pilih: ')
        if pilih == '0':
            tampilkan_data('teacher')
        elif pilih == '1':
            tampilkan_data('student')
        elif pilih == '2':
            tambah_data()
        elif pilih == '3':
            edit_data()
        elif pilih == '4':
            hapus_data()
        elif pilih == '5':
            input_uh(pass_attempt_generator)
        elif pilih == '6':
            login(pass_attempt_generator)
        else:
            print('Invalid Choice')
            
def input_uh(pass_attempt_generator):
    try:
        try_attempt = next(pass_attempt_generator)
        temp_data = {
            "exam_attempt_left": try_attempt,
            "last_date": "30-01-2020"
        }
        f = open('conf.txt','w+')
        f.write(str(temp_data))
        f.close()
    except StopIteration:
        print('UH Sudah dilakukan 3 kali, coba lagi besok')
        return
    except Exception as e:
        print('Something went wrong')
        return
    tampilkan_data('student')
    selected_id = int(input('Pilih berdasarkan id UH yang akan diinput'))
    temp_dict = load_dict()
    if selected_id > len(temp_dict) - 1 or selected_id < 0:
        print('ID tidak ditemukan')
        return
    else:
        print("Menginput nilai untuk:", temp_dict[selected_id]['nama'])
        if try_attempt == 3: temp_dict[selected_id]['nilai_uh_1'] = input('Input UH ke-1\nNilai UH ke-1: ')
        elif try_attempt == 2: temp_dict[selected_id]['nilai_uh_2'] = input('Input UH ke-2\nNilai UH ke-2: ')
        elif try_attempt == 1: temp_dict[selected_id]['nilai_uh_3'] = input('Input UH ke-3\nNilai UH ke-3: ')
        else:
            print('Something went wrong')
            return
        save_dict(temp_dict)

def tampilkan_data(lihat):
    print('\n[Tampilkan Data]')
    for index,i in enumerate(initiate_dict_iterator(load_dict())):
        if i['role'] == lihat or lihat == 'all':
            print('\nID: ', index)
            print('Nama: ', i['nama'])
            if i['role'] != 'teacher':
                avg_uh = lambda nilai1, nilai2, nilai3: (nilai1 + nilai2 + nilai3) / 3
                print('Nilai UH: ', avg_uh(int(i['nilai_uh_1']), int(i['nilai_uh_2']), int(i['nilai_uh_3'])))
                print('Nilai UAS: ', i['nilai_uas'])
                nilai_akhir = lambda nilai1, nilai2: (nilai1 + nilai2) / 2
                print('Nilai Akhir: ', nilai_akhir(avg_uh(int(i['nilai_uh_1']), int(i['nilai_uh_2']), int(i['nilai_uh_3'])), i['nilai_uas']))

def tambah_data():
    print('\n[Tambah Data]')
    new_role = input('1. Teacher\n2. Student\nPilih Role: ') or '2'
    while True:
        new_username = input('Username: ')
        if new_username == '': print('Username tidak boleh kosong')
        else: break
    while True:
        new_password = input('Password: ')
        if new_password == '': print('Password tidak boleh kosong')
        else: break
    while True:
        new_nama = input('Nama: ')
        if new_nama == '': print('Nama tidak boleh kosong')
        else: break
    new_uh1 = input('Nilai UH 1 (0): ') or '0'
    new_uh2 = input('Nilai UH 2 (0): ') or '0'
    new_uh3 = input('Nilai UH 3 (0): ') or '0'
    new_uas = input('Nilai UAS (0): ') or '0'
    temp_dict = load_dict()
    temp_dict.append({
        'role': 'student' if new_role == '2' else 'teacher',
        'username': new_username,
        'password': new_password,
        'nama': new_nama,
        'nilai_uh_1': int(new_uh1),
        'nilai_uh_2': int(new_uh2),
        'nilai_uh_3': int(new_uh3),
        'nilai_uas': int(new_uas)
    })
    save_dict(temp_dict)
    print('Data berhasil ditambahkan')

def edit_data():
    print('\n[Edit Data]')
    tampilkan_data('all')
    print('Pilih id data yang akan diedit')
    id = int(input('ID: '))
    if id > len(load_dict()) - 1 or id < 0:
        print('ID tidak ditemukan')
    else :
        new_role = input('1. Teacher\n2. Student\nPilih Role ('+load_dict()[id]["role"]+'): ') or '2'
        new_username = input('Username ('+load_dict()[id]["username"]+'): ') or load_dict()[id]['username']
        new_password = input('Password: ('+load_dict()[id]["password"]+')') or load_dict()[id]['password']
        new_nama = input('Nama: ('+load_dict()[id]["nama"]+')') or load_dict()[id]['nama']
        new_uh1 = input('Nilai UH 1: ('+str(load_dict()[id]["nilai_uh_1"])+')') or load_dict()[id]['nilai_uh_1']
        new_uh2 = input('Nilai UH 2: ('+str(load_dict()[id]["nilai_uh_2"])+')') or load_dict()[id]['nilai_uh_2']
        new_uh3 = input('Nilai UH 3: ('+str(load_dict()[id]["nilai_uh_3"])+')') or load_dict()[id]['nilai_uh_3']
        new_uas = input('Nilai UAS: ('+str(load_dict()[id]["nilai_uas"])+')') or load_dict()[id]['nilai_uas']
        temp_dict=load_dict()
        temp_dict[id] = {
            'role': 'student' if new_role == '2' else 'teacher', 
            'username': new_username,
            'password': new_password,
            'nama': new_nama,
            'nilai_uh_1': int(new_uh1),
            'nilai_uh_2': int(new_uh2),
            'nilai_uh_3': int(new_uh3),
            'nilai_uas': int(new_uas)
        }
        save_dict(temp_dict)
        print('Data berhasil diedit')

def hapus_data():
    print('\n[Hapus Data]')
    tampilkan_data('all')
    print('Pilih id data yang akan dihapus')
    id = int(input('ID: '))
    if id > len(load_dict()) - 1 or id < 0:
        print('ID tidak ditemukan')
    else :
        temp_dict=load_dict()
        temp_dict.pop(id)
        save_dict(temp_dict)
        print('Data berhasil dihapus')

def student_menu(index, pass_attempt_generator):
    print('\n[Student\'s Data]')
    print('Nama: ', load_dict()[index]['nama'])
    avg_uh = lambda nilai1, nilai2, nilai3: (nilai1 + nilai2 + nilai3) / 3
    avg_uh_result = avg_uh(int(load_dict()[index]['nilai_uh_1']), int(load_dict()[index]['nilai_uh_2']), int(load_dict()[index]['nilai_uh_3']))
    print('Nilai UH: ', avg_uh_result)
    print('Nilai UAS: ', load_dict()[index]['nilai_uas'],'\n')    
    nilai_akhir = lambda nilai1, nilai2: (nilai1 + nilai2) / 2
    print('Nilai Akhir: ', nilai_akhir(avg_uh_result, load_dict()[index]['nilai_uas']))
    login(pass_attempt_generator)

def login(pass_attempt_generator):
    while True:
        username = input('\n[Login]\nUsername: ')
        password = input('Password: ')
        for index,i in enumerate(load_dict()):
            if i['username'] == username and i['password'] == password:
                login_splitter = lambda role: teacher_menu(pass_attempt_generator) if role == 'teacher' else student_menu(index, pass_attempt_generator)
                login_splitter(i['role'])
                return

def kalibrasi_tanggal():
    f = open('conf.txt', 'r')
    conf = f.read()
    print("Tanggal Terakhir:",eval(conf)['last_date'])
    new_tanggal = input("Masukkan Tanggal("+eval(conf)['last_date']+"):") or eval(conf)['last_date']
    if new_tanggal == eval(conf)['last_date']:
        pass_attempt_generator = reset_exam_attempt(int(eval(conf)['exam_attempt_left']))
    else:
        temp_data = {
            "exam_attempt_left": 3,
            "last_date": new_tanggal
        }
        f = open('conf.txt','w+')
        f.write(str(temp_data))
        f.close()
        print("Nilai UH Reset!")
        pass_attempt_generator = reset_exam_attempt(3)
    login(pass_attempt_generator)

kalibrasi_tanggal()