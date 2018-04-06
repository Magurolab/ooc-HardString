import os

dir = [d for d in os.listdir() if ".png" in d]

# import ThreeDPrinter from "../Board/cards_img/3DPrinter.png"
for e in os.listdir():
    if ".png" in e:
        # print("import",e[:-4],"from", "'" + "../Board/cards_img/"+e+"'" )
        print('"' +e[:-4]+'"'+":"+e[:-4]+",")
