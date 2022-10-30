data1 = ["21 hari 20 jam 9 menit 20 detik","19 hari 14 jam 0 menit 13 detik","1 hari 1 jam 1 menit 1 detik"]
data2 = ["3 minggu 3 hari 7 jam 21 menit","5 minggu 5 hari 8 jam 11 menit","7 minggu 1 hari 5 jam 33 menit"]

def konversi(minggu=0):
    def hari(hari=0):
        def jam(jam=0):
            def menit(menit=0):
                def detik(detik=0):
                    return (minggu*7*24*60) + (hari*24*60) + (jam*60) + menit + (detik/60)
                return detik
            return menit
        return jam
    return hari

def parsing_waktu(data):
    total_minggu = total_hari = total_jam = total_menit = total_detik = 0
    return_list = []
    for i in data:
        if 'minggu' in i: total_minggu = int(i.split('minggu')[0])
        if 'hari' in i:
            try: total_hari = int(i.split('hari')[0].split('minggu')[1])
            except: total_hari = int(i.split('hari')[0])
        if 'jam' in i:
            try: total_jam = int(i.split('jam')[0].split('hari')[1])
            except: total_jam = int(i.split('jam')[0])
        if 'menit' in i:
            try: total_menit = int(i.split('menit')[0].split('jam')[1])
            except: total_menit = int(i.split('menit')[0])
        if 'detik' in i:
            try: total_detik = int(i.split('detik')[0].split('menit')[1])
            except: total_detik = int(i.split('detik')[0])
        return_list.append(int(konversi(total_minggu)(total_hari)(total_jam)(total_menit)(total_detik)))
    return return_list

print(parsing_waktu(data2))
print(parsing_waktu(data1))