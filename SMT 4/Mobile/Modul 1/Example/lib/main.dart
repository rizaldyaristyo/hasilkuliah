import 'package:flutter/material.dart';
import 'user.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    User ngabers = User(
      firstName: 'Ngabers',
      lastName: 'Ngabs',
      nim: '202010370311999',
    );
    User rijal = User(
      firstName: 'Rijaldi',
      lastName: 'Arst',
      nim: '202010370311440',
      age: 77,
    );
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          backgroundColor: const Color(0xFFFF5861),
          title: const Text(
            'Labit UMM',
          ),
        ),
        body: Padding(
          padding: EdgeInsets.all(8.0),
          child: Column(
            children: [
              Container(
                width: double.infinity,
                height: 100,
                color: Colors.grey[300],
                child: Padding(
                  padding: EdgeInsets.all(8.0),
                  child: Row(
                    children: [
                      Image.network('https://github.com/arstcreations.png'),
                      Padding(padding: EdgeInsets.only(left: 10.0)),
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(rijal.getFullName()),
                          Text('Teknik / Informatika'),
                          Text(rijal.getNim()),
                          Text('https://arstcreations.github.io'),
                        ],
                      )
                    ],
                  ),
                ),
              ),
              Container(
                width: double.infinity,
                height: 100,
                color: Colors.grey[300],
                child: Padding(
                  padding: EdgeInsets.all(8.0),
                  child: Row(
                    children: [
                      Image.network('https://github.com/arstcreations.png'),
                      Padding(padding: EdgeInsets.only(left: 10.0)),
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(ngabers.getFullName()),
                          Text('Teknik / Informatika'),
                          Text(ngabers.getNim()),
                          Text('https://arstcreations.github.io'),
                        ],
                      )
                    ],
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
