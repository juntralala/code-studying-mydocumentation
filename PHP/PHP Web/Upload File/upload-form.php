<?php
if($_SERVER["REQUEST_METHOD"] === "POST"){
    $file_name = $_FILES["nama_file"]['name'];
    $file_type = $_FILES["nama_file"]['type'];
    $file_size = $_FILES["nama_file"]['size'];
    $file_tmp_name = $_FILES["nama_file"]['tmp_name'];
    $file_error = $_FILES["nama_file"]['error'];

    move_uploaded_file($file_tmp_name, __DIR__.'/file/'.$file_name);
}
?>

<html>
<body>
    <h1>Form Upload</h1>
    <form method="post" action="upload-form.php" enctype="multipart/form-data">
        <label for="">File : 
            <input type="file" name="nama_file" id="nama_file">
        </label>
        <button type="submit">Upload</button>
    </form>

    <?php if($_SERVER['REQUEST_METHOD'] == 'POST'){ ?>
        <table>
            <caption><b>Uploaded File</b></caption>
            <tr>
                <th>File Name</th>
                <td><?=$file_name?></td>
            </tr>
            <tr>
                <th>File Type</th>
                <td><?= $file_type ?></td>
            </tr>
            <tr>
                <th>File Size</th>
                <td><?= $file_size ?></td>
            </tr>
            <tr>
                <th>File Tmp Name</th>
                <td><?= $file_tmp_name ?></td>
            </tr>
            <tr>
                <th>File Error</th>
                <td><?= $file_error ?></td>
            </tr>
        </table>
    <?php } ?>
</body>
</html>