import 'dart:convert';

import 'artikelsapi.dart';
import 'package:flutter/material.dart';
import 'bottomnavbar.dart';
import 'preferences.dart';

TextEditingController data1 = TextEditingController();
TextEditingController data2 = TextEditingController();
TextEditingController data3 = TextEditingController();
TextEditingController data4 = TextEditingController();
TextEditingController data5 = TextEditingController();

class ArtikelsList extends StatefulWidget {
  const ArtikelsList({Key? key}) : super(key: key);

  @override
  State<ArtikelsList> createState() => _ArtikelsListState();
}

class _ArtikelsListState extends State<ArtikelsList> {
  Map<String, dynamic>? data;
  _getData() async {
    data = await Services().artikelsCRUDApi();
    print(data!['data'][0]['id']);
    setState(() {});
  }

  @override
  initState() {
    super.initState();
    _getData();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: abuabu900,
        appBar: AppBar(
          title: const Text('YouTube Guidelines'),
          backgroundColor: abuabu700,
          actions: [
            GestureDetector(
              child: const Icon(Icons.settings),
              onTap: () async {
                // Settings Dialog
                await showDialog(
                    context: context,
                    builder: (BuildContext context) {
                      return SingleChildScrollView(
                        child: AlertDialog(
                          title: const Text('Settings'),
                          content: Container(
                            height: MediaQuery.of(context).size.height * 0.5,
                            child: Column(
                              children: [
                                TextField(
                                  controller: data1,
                                  decoration: InputDecoration(
                                    labelText: 'Deo Juvante Api URL',
                                  ),
                                ),
                                TextField(
                                  controller: data2,
                                  decoration: InputDecoration(
                                    labelText: 'Admin Email',
                                  ),
                                ),
                                TextField(
                                  controller: data3,
                                  obscureText: true,
                                  decoration: InputDecoration(
                                    labelText: 'Admin Password',
                                  ),
                                ),
                              ],
                            ),
                          ),
                          actions: [
                            ElevatedButton(
                              child: const Text('Save'),
                              onPressed: () async {
                                print("config: " +
                                    data1.text +
                                    " " +
                                    data2.text +
                                    " " +
                                    data3.text);
                                Navigator.of(context).pop();
                                apiURL = data1.text;
                                token = await Services()
                                    .getToken(data2.text, data3.text);
                                _getData();
                              },
                            ),
                            ElevatedButton(
                              child: const Text('Cancel'),
                              onPressed: () {
                                Navigator.of(context).pop();
                                deletePref();
                              },
                            ),
                          ],
                        ),
                      );
                    });
              },
            ),
            Padding(padding: EdgeInsets.only(right: 20)),
            GestureDetector(
              child: const Icon(Icons.refresh),
              onTap: () async {
                _getData();
              },
            ),
            Padding(padding: EdgeInsets.only(right: 20)),
          ],
        ),
        body: Container(
          child: ListView.builder(
              itemCount: data == null ? 1 : data!['data'].length,
              itemBuilder: (BuildContext context, int index) {
                if (data != null) {
                  return GestureDetector(
                    onTap: () {
                      // Edit Page
                      AlertDialog editArtikels = AlertDialog(
                        title: const Text('Edit Guideline'),
                        content: Column(
                          mainAxisSize: MainAxisSize.min,
                          children: [
                            TextField(
                              controller: data1,
                              decoration: const InputDecoration(
                                labelText: 'Judul',
                              ),
                            ),
                            TextField(
                              controller: data2,
                              decoration: const InputDecoration(
                                labelText: 'Isi Konten',
                              ),
                            ),
                            TextField(
                              controller: data3,
                              decoration: const InputDecoration(
                                labelText: 'Image',
                              ),
                            ),
                            TextField(
                              controller: data4,
                              decoration: const InputDecoration(
                                labelText: 'Author ID',
                              ),
                            ),
                            TextField(
                              controller: data5,
                              decoration: const InputDecoration(
                                labelText: 'Category ID',
                              ),
                            ),
                          ],
                        ),
                        actions: [
                          ElevatedButton(
                            child: const Text('Cancel'),
                            onPressed: () {
                              Navigator.pop(context);
                            },
                          ),
                          ElevatedButton(
                            child: const Text('Save'),
                            onPressed: () {
                              Navigator.pop(context);
                              Services().patchArtikels(
                                  id: data!['data'][index]['id'].toString(),
                                  judul: data1.text,
                                  isiKonten: data2.text,
                                  image: data3.text,
                                  authorId: data4.text,
                                  categoryId: data5.text);
                              _getData();
                            },
                          ),
                        ],
                      );
                      showDialog(
                          context: context,
                          useRootNavigator: false,
                          builder: (BuildContext context) {
                            return SingleChildScrollView(child: editArtikels);
                          });
                    },
                    onLongPress: () {
                      // Delete Page
                      AlertDialog deleteAlert = AlertDialog(
                        title: const Text('Remove Guideline'),
                        content: const Text('Are you sure?'),
                        actions: [
                          ElevatedButton(
                            child: const Text('Cancel'),
                            onPressed: () {
                              Navigator.pop(context);
                            },
                          ),
                          ElevatedButton(
                            child: const Text('Delete'),
                            onPressed: () {
                              // print('deleting' + data!['data'][index]['id'].toString());
                              Navigator.pop(context);
                              Services().deleteArtikels(
                                  data!['data'][index]['id'].toString());
                              _getData();
                            },
                          ),
                        ],
                      );
                      showDialog(
                          context: context,
                          useRootNavigator: false,
                          builder: (BuildContext context) {
                            return SingleChildScrollView(child: deleteAlert);
                          });
                    },
                    child: Column(
                      children: [
                        Padding(padding: EdgeInsets.only(top: 10)),
                        Container(
                          color: Colors.green,
                          child: ListTile(
                            leading: Icon(
                              Icons.book,
                              color: putih,
                            ),
                            title: Text(
                              data!['data'][index]['judul'],
                              style: TextStyle(color: putih),
                              overflow: TextOverflow.ellipsis,
                            ),
                            subtitle: Text(
                              data!['data'][index]['isi_konten'],
                              style: TextStyle(color: putih),
                              overflow: TextOverflow.ellipsis,
                            ),
                          ),
                        ),
                      ],
                    ),
                  );
                } else {
                  return ListTile(
                    title: Text('Loading...', style: TextStyle(color: putih)),
                  );
                }
              }),
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: () {
            // Add Artikels Page
            AlertDialog addArtikelPage = AlertDialog(
              title: const Text('Add Guideline'),
              content: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  TextField(
                    controller: data1,
                    decoration: const InputDecoration(
                      labelText: 'Judul',
                    ),
                  ),
                  TextField(
                    controller: data2,
                    decoration: const InputDecoration(
                      labelText: 'Isi Konten',
                    ),
                  ),
                  TextField(
                    controller: data3,
                    decoration: const InputDecoration(
                      labelText: 'Image',
                    ),
                  ),
                  TextField(
                    controller: data4,
                    decoration: const InputDecoration(
                      labelText: 'Author ID',
                    ),
                  ),
                  TextField(
                    controller: data5,
                    decoration: const InputDecoration(
                      labelText: 'Category ID',
                    ),
                  ),
                ],
              ),
              actions: [
                ElevatedButton(
                  child: const Text('Cancel'),
                  onPressed: () {
                    Navigator.pop(context);
                  },
                ),
                ElevatedButton(
                  child: const Text('Save'),
                  onPressed: () {
                    Navigator.pop(context);
                    Services().postArtikels(
                        judul: data1.text,
                        isiKonten: data2.text,
                        image: data3.text,
                        authorId: int.parse(data4.text),
                        categoryId: int.parse(data5.text));
                        _getData();
                        },  
                      )
              ]
            );
            showDialog(
                context: context,
                useRootNavigator: false,
                builder: (BuildContext context) {
                  return SingleChildScrollView(child: addArtikelPage);
                });
          },
          child: const Icon(Icons.add),
        ),
        bottomNavigationBar: const BottomNavBar());
  }
}
