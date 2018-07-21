SHA=$(git rev-parse HEAD)
PRE_LAST_SHA=$(git rev-parse @~)
BRANCH=$(git rev-parse --abbrev-ref HEAD)

GITHUB_TOKEN=$GITHUB_SECRET_TOKEN
PULL_REQUEST_ID=$TRAVIS_PULL_REQUEST
OWNER_NAME="tarek360"
REPO_NAME="emptyapp"

COMMENT_TITLE="## Detekt report:\n❌"
while read -r line || [[ -n "$line" ]]; do
    data+=$(echo "$line")
    data+="\n\n"
done < "reports/detekt/output/detekt-plain.txt"
BODY="$COMMENT_TITLE\n\`\`\`\n$data\`\`\`"

url="https://api.github.com/repos/$OWNER_NAME/$REPO_NAME/commits/$SHA/comments"

# Create comment
echo "Create comment.. for SHA: $SHA in PR: $PULL_REQUEST_ID"
curl -H 'Host: api.github.com' -H 'Content-Type: application/json' -H "Authorization: token $GITHUB_TOKEN" --data-binary "{\"body\":\"${BODY}\"}" --compressed $url
