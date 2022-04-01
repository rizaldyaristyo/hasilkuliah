import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: DefaultTabController(
        length: 5,
        child: Scaffold(
          appBar: AppBar(
            backgroundColor: Colors.red,
            title: SizedBox(
              width: 50,
              child: Image.network(
                'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e1/Logo_of_YouTube_%282015-2017%29.svg/320px-Logo_of_YouTube_%282015-2017%29.svg.png',
                fit: BoxFit.contain,
              ),
            ),
            actions: <Widget>[
              Padding(
                padding: EdgeInsets.all(10.0),
                child: GestureDetector(
                  onTap: () {},
                  child: const Icon(
                    Icons.search,
                    size: 26.0,
                  ),
                ),
              ),
              Padding(
                padding: const EdgeInsets.only(
                  right: 20.0,
                  left: 5.0,
                ),
                child: GestureDetector(
                  onTap: () {},
                  child: const Icon(
                    Icons.account_circle_rounded,
                    size: 26.0,
                  ),
                ),
              ),
            ],
          ),
          body: SingleChildScrollView(
            child: Column(
              children: [
                Padding(padding: EdgeInsets.only(right: 10, left: 10, top: 10)),
                const Text(
                  'Recommended',
                  textAlign: TextAlign.end,
                ),
                Column(
                  children: [
                    Padding(padding: EdgeInsets.only(top: 5)),
                    Container(
                      margin: EdgeInsets.only(top: 10),
                      width: double.infinity,
                      height: 180,
                      color: Colors.grey,
                      child: Image.network(
                        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPYztjfKWOhRiNJqGfRse9DDwe_1tCeqo-HYHtsSl9qFZ6smHaXd05URuB6vTfHNP0BhY&usqp=CAU',
                        fit: BoxFit.cover,
                      ),
                    ),
                    Row(
                      children: [
                        Container(
                          margin: EdgeInsets.all(8.0),
                          child: ClipRRect(
                            borderRadius: BorderRadius.circular(30.0),
                            child: Image.network(
                              'https://cutewallpaper.org/22/halloween-profile-pictures-wallpapers/1333125595.jpg',
                              height: 35.0,
                              width: 35.0,
                            ),
                          ),
                        ),
                        Column(
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text('NEMU E\'3K EMAS DI SUNGAI GAEEESSSSSS!',
                                style: TextStyle(
                                    fontWeight: FontWeight.bold, fontSize: 13)),
                            Text('Orangutan ngeGamingzszsz Di Selokann Channel',
                                style: TextStyle(
                                    fontWeight: FontWeight.w300, fontSize: 12))
                          ],
                        )
                      ],
                    ),
                  ],
                ),
              ],
            ),
          ),
          bottomNavigationBar: BottomNavigationBar(
            unselectedItemColor: Colors.grey,
            selectedItemColor: Colors.red,
            items: const [
              BottomNavigationBarItem(icon: Icon(Icons.home), label: 'Home'),
              BottomNavigationBarItem(
                  icon: Icon(Icons.explore), label: 'Explore'),
              BottomNavigationBarItem(icon: Icon(Icons.sensors), label: 'Live'),
              BottomNavigationBarItem(
                  icon: Icon(Icons.access_time), label: 'History'),
              BottomNavigationBarItem(
                  icon: Icon(Icons.add_circle_outline), label: 'Add'),
            ],
          ),
        ),
      ),
    );
  }
}
