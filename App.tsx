/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, { useEffect } from "react";
import type {PropsWithChildren} from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
  NativeModules, Button
} from "react-native";

import {
  Colors,
  DebugInstructions,
  Header,
  LearnMoreLinks,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';


type SectionProps = PropsWithChildren<{
  title: string;
}>;

function Section({children, title}: SectionProps): JSX.Element {
  const isDarkMode = useColorScheme() === 'dark';
  return (
    <View style={styles.sectionContainer}>
      <Text
        style={[
          styles.sectionTitle,
          {
            color: isDarkMode ? Colors.white : Colors.black,
          },
        ]}>
        {title}
      </Text>
      <Text
        style={[
          styles.sectionDescription,
          {
            color: isDarkMode ? Colors.light : Colors.dark,
          },
        ]}>
        {children}
      </Text>
    </View>
  );
}

function App(): JSX.Element {
  const {AstrapaySdkModule} = NativeModules;

  const onPress = () => {
    AstrapaySdkModule.setupAstrapaySdk('testing token');
  };

  const getSdkToken = () => {
    const token = AstrapaySdkModule.getSdkToken('coba ini');
    console.log(token);
  };

  const execute = () => {
    AstrapaySdkModule.navigateToQris(
      'eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzUxMiJ9.eyJzdWIiOiIwODc4NzU3NTQyOTciLCJyb2xlcyI6WyJMT0dJTiJdLCJpc3MiOiJBc3RyYVBheS1EZXYiLCJ0eXBlIjoiQUNDRVNTIiwidXNlcklkIjoxOTk5NDksInRyYW5zYWN0aW9uSWQiOiIiLCJ0cmFuc2FjdGlvblR5cGUiOiIiLCJhY2NvdW50SWQiOjUzOSwiYWNjb3VudElkUG9pbnQiOjAsIm5iZiI6MTcwMjM2MzY2MCwidXNlclR5cGUiOiJDVVNUT01FUiIsImV4cCI6MTcwMjM3MDg2MCwiaWF0IjoxNzAyMzYzNjYwLCJqdGkiOiJhMWIxNmZhNy1hNjMyLTRkOWQtODRhMi01NGFhYTYyOWQzZWQiLCJlbWFpbCI6WyJhMmgyaGVtaW5nd2F5QGljbG91ZC5jb20iXX0.gBEZ1wWNHhJsl8Ou154AhGbu2DAv1_xw4_8jucKGSJW8NVjh6oCACEbvTWcgEiJ03806EV8LTp45FUGvuy7vFMyTooRA98Q5QypxYzudeWbYeslbw_HDfYWgTeWA_n-dOVmwPqOt2xnv_1cRrg_Sj-7YnmpOnxkxzclIhYFqPci1FSkKAYl8MOi_nbLSomcFvjrLJfe3y6IwYfYpYzAj3qrSYE6eelwaQ_J0tI0fjW7wcYW_fBmmrExKVpKQkaxxiUnI2s25ApnUUJbHbz-Jhh_O_yWe8m-cfPJMk3PV4HjGnn2FcJU7innWqRdnZNj5gO3YSJWFhnAT6y-c83N5wQ'
    );
  };

  const setupQris = () => {
    AstrapaySdkModule.setUpQris();
  };

  useEffect(() => {
    setupQris();
    onPress();
    getSdkToken();
  }, []);
  const isDarkMode = useColorScheme() === 'dark';

  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };

  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar
        barStyle={isDarkMode ? 'light-content' : 'dark-content'}
        backgroundColor={backgroundStyle.backgroundColor}
      />
      <ScrollView
        contentInsetAdjustmentBehavior="automatic"
        style={backgroundStyle}>
        <Header />
        <View
          style={{
            backgroundColor: isDarkMode ? Colors.black : Colors.white,
          }}>
          <Section title="Step One">
            Edit <Text style={styles.highlight}>App.tsx</Text> to change this
            screen and then come back to see your edits.
          </Section>
          <Section title="Percobaan">
            <Button title="QRIS" onPress={() => execute()} />
          </Section>
          <Section title="See Your Changes">
            <ReloadInstructions />
          </Section>
          <Section title="Debug">
            <DebugInstructions />
          </Section>
          <Section title="Learn More">
            Read the docs to discover what to do next:
          </Section>
          <LearnMoreLinks />
        </View>
      </ScrollView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
  },
  highlight: {
    fontWeight: '700',
  },
});

export default App;
