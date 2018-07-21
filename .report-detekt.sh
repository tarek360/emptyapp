# 1- Create Github personal access token from here https://github.com/settings/tokens/new

# 2 Configure your CI

# ********************************* For Travis CI *********************************
# Use the next command to add the Github personal access token as encrypted global variable
# $ travis encrypt GITHUB_SECRET_TOKEN="Github Personal access token" --add
# You have to see the next lines in the job log
# Setting environment variables from .travis.yml
# $ export GITHUB_SECRET_TOKEN=[secure]

# Set the request params
GITHUB_TOKEN=$GITHUB_SECRET_TOKEN
PULL_REQUEST_ID=$TRAVIS_PULL_REQUEST
OWNER_NAME="tarek360"
REPO_NAME="emptyapp"
COMMIT_TITLE=""
COMMIT_MESSAGE=""

SHA=$(git rev-parse HEAD)

url="https://api.github.com/repos/$OWNER_NAME/$REPO_NAME/statuses/$SHA"

echo "Create status.. for SHA: $SHA in PR: $PULL_REQUEST_ID"


BRANCH=$(git rev-parse --abbrev-ref HEAD)
echo "BRANCH: $BRANCH"
echo "SHA: SHA"
