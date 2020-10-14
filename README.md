# ViewBindingExample

**Important** enable `ViewBinding` on your project, setup in `gradle`.

```gradle
android {

    ...
    
    //Android Studio Version Until 4
    viewBinding {
        enabled = true
    }
    
    //Android Studio Version 4 -> gradle version 6.1.1 -> android gradle plugin version 4.0.0
    buildFeatures{
        viewBinding = true
    }

}
```
#
#### ViewBinding On Activity

> activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:text="Hallo Zein"
        android:id="@+id/my_text_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</LinearLayout>
```

> MainActivity.java

```java
public class MainActivity extends AppCompatActivity implements AdapterRVMultiType.MyOnClick {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        binding.myTextView.setText("Hallo GZeinNumer");
    }
}
```