import json, argparse

parser = argparse.ArgumentParser(description="Generats the fa_icons.xml file containing string values based on a provided JSON input. You can find the required JSON file in the zip file downloaded directly from Font Awesome. It should be located in ./metadata/icons.json")
parser.add_argument('-f', '--json-file', action="store", dest="FILE", help="The JSON file to use for generating icons", required=True)
options = parser.parse_args()

with open(options.FILE) as json_file:
    icons = json.load(json_file)
    with open('./fontawesome/src/main/res/values/fa_icons.xml', 'w') as output_file:
        output_file.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n")
        for icon in icons:
            output_file.write("    <string name=\"fa_{}\">&#x{};</string>\n".format(icon.replace("-", "_"), icons[icon]['unicode']))
        output_file.write("</resources>")


