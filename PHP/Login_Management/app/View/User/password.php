<?php require __DIR__ . "/../header.php";?>

<div class="container col-xl-10 col-xxl-8 px-4 py-5">

    <?php if(isset($model['error'])) { ?>
    <div class="row">
        <div class="alert alert-danger" role="alert">
            <?= $model['error'] ?>
        </div>
    </div>
    <?php } ?>

    <div class="row align-items-center g-lg-5 py-5">
        <div class="col-lg-7 text-center text-lg-start">
            <h1 class="display-4 fw-bold lh-1 mb-3">Password</h1>
            <p class="col-lg-10 fs-4">by <a target="_blank" href="https://www.programmerzamannow.com/">Programmer Zaman
                Now</a></p>
        </div>
        <div class="col-md-10 mx-auto col-lg-5">
            <form class="p-4 p-md-5 border rounded-3 bg-light" method="post" action="/users/password">
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="id" placeholder="id" value="<?= $model['user']['id'] ?>" disabled>
                    <label for="id">Id</label>
                </div>
                <div class="form-floating mb-3">
                    <input name="oldPassword" type="password" class="form-control" id="oldPassword" placeholder="old password">
                    <label for="oldPassword">Old Password</label>
                </div>
                <div class="form-floating mb-3">
                    <input name="newPassword" type="password" class="form-control" id="newPassword" placeholder="password">
                    <label for="newPassword">New Password</label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Change Password</button>
            </form>
        </div>
    </div>
</div>

<?php require __DIR__ . "/../footer.php";?>