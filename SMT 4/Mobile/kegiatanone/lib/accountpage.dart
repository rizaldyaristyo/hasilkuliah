// ignore_for_file: prefer_const_constructors, prefer_const_literals_to_create_immutables, avoid_print

import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:kegiatantwo/pageone.dart';
import 'package:kegiatantwo/preferences.dart';
import 'package:kegiatantwo/dummy_data.dart';
import 'package:flutter/services.dart';
import 'package:kegiatantwo/auth.dart';

const List<Map<String, dynamic>> accountlist = DummyData.data;
int? selectedIndex;
AuthenticationService service = AuthenticationService(FirebaseAuth.instance);

class AccountPage extends StatefulWidget {
  const AccountPage({Key? key}) : super(key: key);
  @override
  State<AccountPage> createState() => _AccountPageState();
}

class _AccountPageState extends State<AccountPage> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        appBar: AppBar(
          backgroundColor: abuabu700,
          leading: GestureDetector(
            child: Icon(Icons.arrow_back),
            onTap: () {
              Navigator.of(context).pushAndRemoveUntil(
                  MaterialPageRoute(builder: (context) => PageOne()),
                  (Route<dynamic> route) => false);
            },
          ),
          actions: <Widget>[
            Padding(
              padding: EdgeInsets.all(10.0),
              child: GestureDetector(
                onTap: () {},
                child: const Icon(Icons.account_circle_rounded, size: 26.0),
              ),
            ),
          ],
        ),
        body: Container(
          color: abuabu900,
          child: Padding(
            padding: const EdgeInsets.all(8.0),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  "Your Account",
                  style: TextStyle(fontSize: 22, color: putih),
                ),
                Padding(padding: EdgeInsets.only(top: 10)),
                GestureDetector(
                  child: Row(children: [
                    Icon(Icons.account_circle_rounded, size: 70, color: putih),
                    Text(usernamenya!,
                        style: TextStyle(fontSize: 20, color: putih))
                  ]),
                  onTap: () {
                    showDialog(
                      context: context,
                      builder: (BuildContext dialogContext) {
                        return PasswordPrompt();
                      },
                    );
                  },
                ),
                Padding(padding: EdgeInsets.only(top: 20)),
                Padding(
                  padding: EdgeInsets.only(left: 5),
                  child: Column(
                    children: [
                      Row(children: [
                        Icon(Icons.settings, size: 30, color: putih),
                        Text("  Settings", style: TextStyle(color: putih))
                      ]),
                      Padding(padding: EdgeInsets.only(top: 10)),
                      GestureDetector(
                        onTap: () {
                          if (abuabu == Colors.grey) {
                            darkmode = false;
                            saveToLocal(usernamenya);
                            setState(() {
                              abuabu900 = Colors.white;
                              abuabu700 = Colors.red;
                              abuabu = Colors.black;
                              putih = Colors.black;
                              hitam = Colors.white60;
                            });
                          } else {
                            darkmode = true;
                            saveToLocal(usernamenya);
                            setState(() {
                              abuabu900 = Colors.grey[900];
                              abuabu700 = Colors.grey[700];
                              abuabu = Colors.grey;
                              putih = Colors.white;
                              hitam = Colors.white10;
                            });
                          }
                        },
                        child: Row(children: [
                          Icon(Icons.dark_mode, size: 30, color: putih),
                          Text("  Switch Themes",
                              style: TextStyle(color: putih))
                        ]),
                      ),
                      Padding(padding: EdgeInsets.only(top: 10)),
                      GestureDetector(
                        onTap: () async {
                          // await deletePref();
                          service.signOut();
                          SystemNavigator.pop();
                        },
                        child: Row(children: [
                          Icon(Icons.power_settings_new,
                              size: 30, color: putih),
                          Text("  Sign Out and Exit",
                              style: TextStyle(color: putih))
                        ]),
                      ),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}

class AccountSwitcher extends StatelessWidget {
  const AccountSwitcher({Key? key, bool? switchorlogin}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return PasswordPrompt();
    // return GestureDetector(
    //   child: SizedBox(
    //     width: double.infinity,
    //     height: 40,
    //     child: Row(
    //       children: [
    //         Icon(Icons.account_circle_rounded),
    //         Padding(padding: EdgeInsets.only(left: 10)),
    //         Flexible(
    //           child: Text(
    //             LOGIN,
    //             style: TextStyle(fontSize: 20),
    //             overflow: TextOverflow.ellipsis,
    //           ),
    //         ),
    //       ],
    //     ),
    //   ),
    //   onTap: () {
    //     showDialog(
    //       context: context,
    //       builder: (BuildContext dialogContext) {
    //         return PasswordPrompt();
    //       },
    //     );
    //   },
    // );
  }
}

TextEditingController mailTf = TextEditingController();
TextEditingController passTf = TextEditingController();

class PasswordPrompt extends StatelessWidget {
  const PasswordPrompt({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text('Enter Password'),
      content: Column(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: [
          TextField(
            controller: mailTf,
            decoration: InputDecoration(
              border: OutlineInputBorder(),
              hintText: 'Email',
            ),
          ),
          TextField(
            obscureText: true,
            controller: passTf,
            decoration: InputDecoration(
              border: OutlineInputBorder(),
              hintText: 'Password',
            ),
          ),
          ElevatedButton(
            onPressed: () async {
              await service.signIn(email: mailTf.text, password: passTf.text);
              if (service.getUserData() != 'null') {
                Navigator.of(context).pushAndRemoveUntil(
                    MaterialPageRoute(builder: (context) => PageOne()),
                    (Route<dynamic> route) => false);
              }
              // if (accountlist[selectedIndex!]['password']
              //         .compareTo(passTf.text) ==
              //     0) {
              //   usernamenya = accountlist[selectedIndex!]['nama'];
              //   loggedIn = true;
              //   saveToLocal(accountlist[selectedIndex!]['nama']);
              //   Navigator.of(context).pushAndRemoveUntil(
              //       MaterialPageRoute(builder: (context) => PageOne()),
              //       (Route<dynamic> route) => false);
              // } else {
              //   print('WRONG PASS!');
              // }
            },
            child: Text('Login'),
          ),
          ElevatedButton(
            onPressed: () {
              service.signUp(email: mailTf.text, password: passTf.text);
            },
            child: Text('Sign Up'),
          ),
          // ElevatedButton(
          //   onPressed: () {
          //     service.signOut();
          //   },
          //   child: Text('Sign Out'),
          // )
        ],
      ),
    );
  }
}
