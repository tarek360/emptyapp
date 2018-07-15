# 1- Create Github personal access token from here https://github.com/settings/tokens/new

# 2 Configure your CI

# ********************************* For Travis CI *********************************
# Use the next command to add the Github personal access token as encrypted global variable
# $ travis encrypt GITHUB_SECRET_TOKEN="Github Personal access token" --add
# You have to
# Setting environment variables from .travis.yml
# $ export GITHUB_SECRET_TOKEN=[secure]


BRANCH=$(git rev-parse --abbrev-ref --quiet HEAD)
echo "Merging branch $BRANCH"

# Set the request params
GITHUB_TOKEN=$GITHUB_SECRET_TOKEN
PULL_REQUEST_ID=$TRAVIS_PULL_REQUEST
OWNER_NAME="tarek360"
COMMIT_TITLE="Merge pull request #$PULL_REQUEST_ID from $OWNER_NAME/$BRANCH"
COMMIT_MESSAGE=""

url="https://api.github.com/repos/tarek360/emptyapp/pulls/$PULL_REQUEST_ID/merge"

echo $url

curl -H 'Host: api.github.com' -H 'Content-Type: application/json' -H "Authorization: token $GITHUB_TOKEN" --data-binary "{\"commit_title\":\"${COMMIT_TITLE}\", \"commit_message\":\"${COMMIT_MESSAGE}\"}" -X PUT --compressed $url