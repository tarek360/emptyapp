git branch
branch=$(git rev-parse --abbrev-ref --quiet HEAD)
echo "Running automerge for branch $branch"
git checkout master
git merge $branch --no-ff --no-edit