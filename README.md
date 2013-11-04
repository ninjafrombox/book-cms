Git module
============

1. Create a repository in Github - https://github.com/ninjafrombox/book-cms
1. Set up git: specify the user name, email and editor
 * git config --global user.name "ninjafrombox"
 * git config --global user.email "ninjafrombox@users.noreply.github.com"
 * git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -notabbar -nosession -noPlugin"
1. Create a local repository, add project to it - 8c4c1c54
 * git init
 * git add .
 * git commit -m "init"
1. Push project to Github
 * git remote add origin git@github.com:ninjafrombox/book-cms.git
 * git push -u origin master
1. Create a new feature in a local branch - 96f16d38
 * git checkout -b b1
 * git commit -a -m "[git] add feature in local branch"
1. Create a new feature in a master branch - 31c223e3
 * git commit -a -m "[git] add commit in master branch"
1. Merge brunch to master branch - a2b98eb0
 * git merge b1 -m "[git] merge commit"
1. Delete the local branch
 * git branch -d b1
1. Configure remote repository to get ready for a big command development (e.g. gitflow)
 * git checkout master
 * git checkout -b develop
 * git push -u origin develop
 * Now we have master & develop branches. So we can follow gitflow.
    * Make changes in 'feature' branch (c50507c2 and 0499aa5e), merge it to develop (dede3afd)
    * Make changes in 'release' branch (2d699d6c), then merge it to master (c80ba700) and develop (0129f4ff)
    * Make changes in 'hotfix' branch (3a9a46a1), then merge it to master (b49a32cb) and develop (121ccbe2)
1. Use format-patch to create patch for last several commits - see git/*.patch
 * git checkout develop
 * git format-patch master
1. You have two branches (master & master2) and must support all of them. You fix bug for 'master2' in 'hotfix-01' and make c1, c2, c3 commits for that. Your task is merge only two commits (c2 and c3) from 'hotfix-01' to development branch 'develop' and to 'master'.
 * git checkout master
 * git checkout -b master2
 * git push -u origin master2
 * git checkout -b hotfix-01
 * git commit -a -m "[git] hotfix c1"
 * git commit -a -m "[git] hotfix c2"
 * git commit -a -m "[git] hotfix c3"
 * git checkout master2
 * git merge --no-ff hotfix-01 -m "[git] merge hotfix c1-c3"
 * git push
 * git checkout hotfix-01
 * git rebase --onto master hotfix-01~2
 * git checkout master
 * git merge --no-ff hotfix-01 -m "[git] merge hotfix c2,c3"
 * git push
 * git checkout hotfix-01
 * git rebase --onto develop hotfix-01~2
 * git checkout develop
 * git merge --no-ff hotfix-01 -m "[git] merge hotfix c2,c3"
 * git push
 * git branch -d hotfix-01
1. Configure client-side commit-msg hook to prevent comments with incorrect format - see git/commit-msg
