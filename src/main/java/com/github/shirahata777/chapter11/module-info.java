module name {
    // 公開したいパッケージを指定
    exports com.github.shirahata777.chapter11;

    // SPIとして利用するインターフェースを指定
    uses com.github.shirahata777.chapter11.Hello;

    // 利用する別のパッケージを指定
    // requires com.github.shirahata777.chapter10;

    // リフレクションを許可するモジュールを指定
    // opens com.github.shirahata777.chapter11.Item to モジュール名;
}

// モジュール全体でリフレクションを許可するには下記のように記載
// open module name {

// }