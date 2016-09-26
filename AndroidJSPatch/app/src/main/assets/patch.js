importClass("android.widget.Toast")


JSPatch.replaceMethod("com.mybank.android.phone.wealth.ui.WealthHomeFragment",
"checkLoginStatus", function(target){
    Toast.makeText(target, "Hello World JSPatch Works", Toast.LENGTH_SHORT).show();
    return false;
});





JSPatch.replaceMethod("com.efurture.patch.demo.MainActivity",
"testBug", function(target){
   Toast.makeText(target, "Hello World JSPatch Works", Toast.LENGTH_SHORT).show();
});


 print("JSPatch Works");

JSPatch.replaceMethod("com.efurture.patch.demo.Bug",
"bug", function(target, args0){
   print("JSPatch Works");
   Toast.makeText(args0, "Hello World JSPatch Works", Toast.LENGTH_SHORT).show();
});
