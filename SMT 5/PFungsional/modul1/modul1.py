users =    [
    {
        'role': 'teacher',
        'username': 'ari',
        'password': 'ari123',
        'nama': 'Ari',
        'nilai_uts': 0,
        'nilai_uas': 0
    },
    {
        'role': 'student',
        'username': 'upi',
        'password': 'upi123',
        'nama': 'Upi',
        'nilai_uts': 100,
        'nilai_uas': 100
    }
]

def teacher_menu():
    while True:
        print('\n[Menu Teacher]\
            \n0.Tampilkan Teachers\
            \n1.Tampilkan Students\
            \n2.Tambah Data\
            \n3.Edit Data\
            \n4.Hapus Data\
            \n5.IZIN OFF')
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
            login()
        else:
            print('Invalid Choice')

def tampilkan_data(lihat):
    print('\n[Tampilkan Data]')
    for index,i in enumerate(users):
        if i['role'] == lihat or lihat == 'all':
            print('\nID: ', index)
            print('Nama: ', i['nama'])
            if i['role'] != 'teacher':
                print('Nilai UTS: ', i['nilai_uts'])
                print('Nilai UAS: ', i['nilai_uas'])
                print('Nilai Akhir: ', (int(i['nilai_uts']) + int(i['nilai_uas'])) / 2)

def tambah_data():
    print('\n[Tambah Data]')
    new_role = input('1. Teacher\n2. Student\nPilih Role: ') or '2'
    new_username = input('Username: ')
    new_password = input('Password: ')
    new_nama = input('Nama: ')
    new_uts = input('Nilai UTS: ')
    new_uas = input('Nilai UAS: ')
    users.append({
        'role': 'student' if new_role == '2' else 'teacher',
        'username': new_username,
        'password': new_password,
        'nama': new_nama,
        'nilai_uts': new_uts,
        'nilai_uas': new_uas
    })
    print('Data berhasil ditambahkan')

def edit_data():
    print('\n[Edit Data]')
    tampilkan_data('all')
    print('Pilih id data yang akan diedit')
    id = int(input('ID: '))
    if id > len(users) - 1 or id < 0:
        print('ID tidak ditemukan')
    else :
        new_role = input('1. Teacher\n2. Student\nPilih Role ('+users[id]["role"]+'): ') or '2'
        new_username = input('Username ('+users[id]["username"]+'): ') or users[id]['username']
        new_password = input('Password: ('+users[id]["password"]+')') or users[id]['password']
        new_nama = input('Nama: ('+users[id]["nama"]+')') or users[id]['nama']
        new_uts = input('Nilai UTS: ('+str(users[id]["nilai_uts"])+')') or users[id]['nilai_uts']
        new_uas = input('Nilai UAS: ('+str(users[id]["nilai_uas"])+')') or users[id]['nilai_uas']
        users[id] = {
            'role': 'student' if new_role == '2' else 'teacher',
            'username': new_username,
            'password': new_password,
            'nama': new_nama,
            'nilai_uts': new_uts,
            'nilai_uas': new_uas
        }
        print('Data berhasil diedit')

def hapus_data():
    print('\n[Hapus Data]')
    tampilkan_data('all')
    print('Pilih id data yang akan dihapus')
    id = int(input('ID: '))
    if id > len(users) - 1 or id < 0:
        print('ID tidak ditemukan')
    else :
        users.pop(id)
        print('Data berhasil dihapus')

def student_menu(index):
    print('\n[Student\'s Data]')
    print('Nama: ', users[index]['nama'])
    print('Nilai UTS: ', users[index]['nilai_uts'])
    print('Nilai UAS: ', users[index]['nilai_uas'],'\n')
    print('Nilai Akhir: ', users[index]['nilai_uts'] + users[index]['nilai_uas'] / 2)
    login()

def login():
    print('\n[Login]')
    username = input('Username: ')
    password = input('Password: ')
    for index,i in enumerate(users):
        if i['username'] == username and i['password'] == password:
            if i['role'] == 'teacher':
                teacher_menu()
            elif i['role'] == 'student':
                student_menu(index)
            return

login()