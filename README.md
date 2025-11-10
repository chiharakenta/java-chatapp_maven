# 環境情報
- openjdk v21
- maven v3.9.11

# 開発環境セットアップ手順
1. クローン
    ```shell
    git clone https://github.com/chiharakenta/java-chatapp_maven.git
    cd java-chatapp_maven
    ```
1. 実行
    ```shell
    mvn jetty:run
    ```

# 本番用ビルド手順
1. ビルド
    ```shell
    mvn clean package
    ```
1. デプロイ
    - target/chatapp.warを本番環境にアップロード
